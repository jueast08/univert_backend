
# Univert Installation

### Warning : You probably should run these commands on a PC, copy the finished files to a USB drive and then copy them to the Raspberry Pi in order to save A LOT of time

### Warning: This is a full localhost build. If you are unable to place the NFC reader application and the Website on the same  terminal, it will be impossible to read nfc

## Recovering the proper files
In order to properly install the application, you must recover the following git repositories

 1. https://github.com/jueast08/univert_backend (Backend - recover **lastest** branch)
 2. https://github.com/jueast08/univert_frontend (Frontend - recover **lastest** branch)


## Creating the proper production files

### Front end
 1. From inside of the **univert_frontend** folder, move the **nfc-pcsc** the same level as **univert_frontend**. (`$> cd univert_front; mv nfc-pcsc ..;` 
 2. While still inside of **univert_frontend** run `$> npm start` to make sure everything works fine (graphically, at least)
 3. If the website and images show up in `localhost:4200` (the may change depending on your machine, so be sure to look out for the console output to get the right port), close the server with `crtl+c`
 4. run `$> npm build --prod` to create the production bundle. The resulting folder that interests you is **dist** (in the **univert_frontend** folder
 5. Run the following commands to prepare the folder : `$> cd dist/web-app; $> mv * ..; cd ../.. `
 6. Keep the **dist** folder prepared for the section "setting up production"

### Backend : Create the .war file
1. The easiest way to create the necessary file is to launch *maven clean install * script using Eclipse
2. If this is not possible, try running `mvn clean install` from inside of the **unvert_backend** folder. You need to install maven to be able do this last step
3. Change the resulting .war file's name to univert.war

## Setting up production

### Front end : Assumes that you have Apache2 already installed

 1. `sudo mv dist /var/www/html`
 2. edit the root directory of  **/etc/apache2/sites-available/000-default.conf ** to **/var/www/html/dist/** (the file that you need to update may differ depending on your system. I am using an Ubuntu 18.10)
 3. `sudo systemctl restart apache2`
 4. You should see the same website that you saw in the first steps on *localhost* in your browser

### Back end : Assumes that you have Tomcat8 and Maria DB already installed
1.  See instructions on creating a database with MariaDB. The username and password should be 'root' and 'root' (for demo purposes) and the name of the database should be called **unvert**
2. use the **univert.sql** file located inside of the **univert_backend** folder to populate the database
3. `sudo mv univert.war /var/lib/tomcat8/webapps`
4. `sudo systemctl restart tomcat8`
5. test http://localhost:8080/univert/univert/questservice/quests/reset in a browser. It should return a json

### NFC Reader : if you have an NFC reader that can be attached to the terminal

 1. Make sure that your system has the proper NFC reader tools installed (on Linux, I needed all of the pscs tools)
 2. `$> cd nfc-pcs; npm run example`


If all goes well, the application should be running in a browser an reading nfc tags (if everything was done in localhost)

