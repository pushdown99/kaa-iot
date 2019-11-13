service kaa-node stop
dpkg --remove kaa-node
dpkg --purge kaa-node
dpkg -i ./server/node/target/kaa-node.deb
service kaa-node start
