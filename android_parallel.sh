#!/usr/bin/env bash



echo ------------------------------REMOVE OLD FIILES ------------------------------------
rm -rf screenShot
rm -rf device_os
rm -rf device_updated
rm -rf appium_ports
rm -rf bootstrap_ports
rm -rf device_name
echo "Done"

mkdir screenShot

echo ------------------------------KILL ALL NODE ----------------------------------------
killall node
echo "killed all node server"



echo --------------------------DEVICES CONNECTED ----------------------------------------
adb devices
adb devices|tail -n +2|cut -sf 1 > devices_updated;

while read line
do
       adb -s $line shell getprop ro.build.version.release | sed -e 's/ //g' >> device_os
done  < devices_updated

while read line
do
       adb -s $line shell getprop ro.product.model | sed -e 's/ //g' >> device_name
done < devices_updated

echo -------------------------------DEVICE CONFIGURATIONS -------------------------------
recordcount=$(wc -l < devices_updated)
echo "Found devices count : " $recordcount

echo "Generated Appium ports"

for i in $(seq 1 $recordcount)
do 
		ports=$(jot -r 1  4000 4050)
		echo $ports >> appium_ports
		echo $ports
done



echo "Generated Bootstrap ports"
for i in $(seq 1 $recordcount) 
do 
		ports=$(jot -r 1  4500 4900)
		echo $ports >> bootstrap_ports
		echo $ports
done

echo "Bootstrap Strap Override"


parallel --no-notice --xapply -a appium_ports -a devices_updated -a bootstrap_ports echo appium --session-override -p {1} -U {2} -bp {3}
parallel --no-notice --xapply -a appium_ports -a devices_updated -a bootstrap_ports appium --session-override -p {1} -U {2} -bp {3} >/dev/null 2>&1 &

echo ----------------------------------------RUNNING TEST IN PARALLEL--------------------

parallel --no-notice --xapply -a appium_ports -a devices_updated -a device_os -a device_name  mvn clean test -Denv.PORT={1} -Denv.DEVICE={2} -Denv.OS={3} -Denv.DEVICENAME={4}