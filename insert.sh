curl -X POST -H "Content-Type: application/json" -d '{"name":"test","family_name":"test","email":"test@test","password":"test", "role":"client"}' localhost:8080/api/user
curl -X POST -H "Content-Type: application/json" -d '{"name":"admin","family_name":"admin","email":"admin@admin","password":"admin", "role":"admin"}' localhost:8080/api/user

curl -X POST -H "Content-Type: application/json" -d '{"name": "DRAM"}' localhost:8080/api/category
curl -X POST -H "Content-Type: application/json" -d '{"name":"EEPROM"}' localhost:8080/api/category
curl -X POST -H "Content-Type: application/json" -d '{"name":"eMMC"}' localhost:8080/api/category
curl -X POST -H "Content-Type: application/json" -d '{"name":"EPROM"}' localhost:8080/api/category
curl -X POST -H "Content-Type: application/json" -d '{"name":"FIFO"}' localhost:8080/api/category
curl -X POST -H "Content-Type: application/json" -d '{"name":"F-RAM"}' localhost:8080/api/category

#DRAM
curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/540656.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "540656", "description": "DRAM LPDDR4 32G 1GX32 FBGA DDP", "category": "DRAM", "price": 13.4 , "stock": 13, "reference": "340-540656-TRAY", "image":"540656.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/4C128M8D3LC12BCN.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "4C128M8D3LC12BCN", "description": "DRAM DDR3, 1G, 128M x 8, 1.35V, 78-ball BGA, 800MHz, Commercial Temp", "category": "DRAM", "price": 6 , "stock": 10, "reference": "913-4C128M8D3LC12BCN", "image":"4C128M8D3LC12BCN.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/LD32128B18BLI.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "LD32128B18BLI", "description": "DRAM 4G, 1.2/1.8V, LPDDR2, 128Mx32, 533MHz, 134 ball BGA (10mmx11.5mm) RoHS, ITO", "category": "DRAM", "price": 56.2 , "stock": 8, "reference": "870-LD32128B18BLI", "image":"LD32128B18BLI.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/468260.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "468260", "description": "DRAM DDR5 16G 2GX8 FBGA", "category": "DRAM", "price": 19.99 , "stock": 29, "reference": " 340-468260-REEL ", "image":"468260.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/C1G16D4.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "C1G16D4", "description": "DRAM 16Gb DDR4 96-Ball FBGA SDRAM", "category": "DRAM", "price": 12.10 , "stock": 38, "reference": "913-C1G16D4-062BCN", "image":"C1G16D4.webp" }' localhost:8080/api/product

#EEPROM
curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/M95P32.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "M95P32", "description": "EEPROM Ultra low-power 32 Mbit Serial SPI Page EEPROM", "category": "EEPROM", "price": 1.4 , "stock": 138, "reference": "511-M95P32-IXMNT", "image":"M95P32.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/AT24CSW010STUM.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "AT24CSW010STUM", "description": "EEPROM 1K, 1.7-3.6V, 1MHz, Ind Temp, 5-SOT23", "category": "EEPROM", "price": 1.12 , "stock": 11, "reference": "579-AT24CSW010STUM", "image":"AT24CSW010STUM.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/AT24CSW080STUM.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "AT24CSW080STUM", "description": "EEPROM 8K, 1.7-3.6V, 1MHz, Ind Tmp, 5-SOT23", "category": "EEPROM", "price": 2.2 , "stock": 300, "reference": "579-AT24CSW080STUM", "image":"AT24CSW080STUM.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/M95M04.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "M95M04", "description": "EEPROM 4-Mbit serial SPI bus EEPROM", "category": "EEPROM", "price": 2.99 , "stock": 120, "reference": "511-M95M04-DRDW6TP", "image":"M95M04.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/BR24G256FVT.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "BR24G256FVT", "description": "EEPROM HIGH END LOW PWR EEPROM", "category": "EEPROM", "price": 1.10 , "stock": 12, "reference": "755-BR24G256FVT", "image":"BR24G256FVT.webp" }' localhost:8080/api/product

#eMMC
curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/EMMC256TY295B111.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "EMMC256TY295B111", "description": "eMMC 256GB eMMC 5.1 (HS400) 153B", "category": "eMMC", "price": 2.4 , "stock": 100, "reference": "524-EMMC256TY295B111", "image":"EMMC256TY295B111.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/THGAMVG9T23BAIL.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "THGAMVG9T23BAIL", "description": "eMMC 64GB v5.1 eMMC (BiCS)", "category": "eMMC", "price": 6.12 , "stock": 110, "reference": "757-THGAMVG9T23BAIL", "image":"THGAMVG9T23BAIL.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/608631.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "608631", "description": "eMMC Industrial Embedded MMC, EM-30, ATS2, 64 GB, 3D TLC Flash, -40 C to +85 C", "category": "eMMC", "price": 7.2 , "stock": 3, "reference": "922-608631", "image":"608631.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/401414.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "401414", "description": "eMMC 64G", "category": "eMMC", "price": 5.99 , "stock": 7, "reference": "340-401414-TRAY", "image":"401414.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/SDINBDA6.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "SDINBDA6", "description": "eMMC WD/SD", "category": "eMMC", "price": 4 , "stock": 87, "reference": "467-SDINBDA6-32G", "image":"SDINBDA6.webp" }' localhost:8080/api/product

#EPROM
curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/DS2505PT.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "DS2505PT", "description": "EPROM 16Kb Add-Only Memory", "category": "EPROM", "price": 0.2 , "stock": 1, "reference": "700-DS2505PT", "image":"DS2505PT.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/BQ2022ALPR.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "BQ2022ALPR", "description": "EPROM 1KB Ser EPROM", "category": "EPROM", "price": 1.12 , "stock": 111, "reference": "595-BQ2022ALPR", "image":"BQ2022ALPR.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/AT27LV020A12JU.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "AT27LV020A12JU", "description": "EPROM 2Mb (256Kx8) OTP 3V 120ns", "category": "EPROM", "price": 0.89 , "stock": 3, "reference": "972-AT27LV020A12JU", "image":"AT27LV020A12JU.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/DS2505T.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "DS2505T", "description": "EPROM 16Kb Add-Only Memory", "category": "EPROM", "price": 1.23 , "stock": 19, "reference": "700-DS2505T", "image":"DS2505T.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/AT27C020.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "AT27C020", "description": "EPROM 2Mb (256Kx8) OTP 5V 55ns", "category": "EPROM", "price": 0.10 , "stock": 18, "reference": "566-AT27C020", "image":"AT27C020.webp" }' localhost:8080/api/product


# FIFO
curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/723642L15PFG.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "723642L15PFG", "description": "FIFO 8KX36K2 BUS BIDIRECTIONAL", "category": "FIFO", "price": 132.4 , "stock": 130, "reference": "972-723642L15PFG", "image":"723642L15PFG.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/72V02L15JG.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "72V02L15JG", "description": "FIFO 1Kx9 3.3V ASYNC FIFO", "category": "FIFO", "price": 16.12 , "stock": 11, "reference": "972-72V02L15JG", "image":"72V02L15JG.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/7285L15PAGI.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "7285L15PAGI", "description": "FIFO", "category": "FIFO", "price": 47.2 , "stock": 3, "reference": "972-7285L15PAGI", "image":"7285L15PAGI.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/72V82L15PAG.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "72V82L15PAG", "description": "FIFO 1Kx9 ASYNCHRONOUS DUAL FIFO 3.3V", "category": "FIFO", "price": 25.99 , "stock": 9, "reference": "972-72V82L15PAG", "image":"72V82L15PAG.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/7204L12SOG.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "7204L12SOG", "description": "FIFO 4K X 9 ASYNC FIFO", "category": "FIFO", "price": 20.10 , "stock": 8, "reference": "972-7204L12SOG", "image":"7204L12SOG.webp" }' localhost:8080/api/product

#F-RAM
curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/15B116QSN108BKXI.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "15B116QSN108BKXI", "description": "F-RAM Memory Serial", "category": "F-RAM", "price": 67.4 , "stock": 100, "reference": "972-15B116QSN108BKXI", "image":"15B116QSN108BKXI.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/85S2MTYPNFGAWR2.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "85S2MTYPNFGAWR2", "description": "F-RAM 2Mbit FRAM, SPI, 1.8 3.6V - SOP8 T&R (125?)", "category": "F-RAM", "price": 39.89 , "stock": 110, "reference": "249-85S2MTYPNFGAWR2", "image":"85S2MTYPNFGAWR2.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/85R4M2TFNGJAE2.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "85R4M2TFNGJAE2", "description": "F-RAM 4Mbit FRAM, 256kbit x16 parallel, 1.8V 3.6V - TSOP44 Tray", "category": "F-RAM", "price": 47.9 , "stock": 30, "reference": "972-85R4M2TFNGJAE2", "image":"85R4M2TFNGJAE2.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/CY15B104Q.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "CY15B104Q", "description": "F-RAM Memory Serial", "category": "F-RAM", "price": 52.99 , "stock": 90, "reference": "972-CY15B104Q", "image":"CY15B104Q.webp" }' localhost:8080/api/product

curl -X POST -H "Content-Type: multipart/form-data" -F file=@./images/MR44V064BMAZAATL.webp localhost:8080/api/file > /dev/null
curl -X POST -H "Content-Type: application/json" -d '{ "name": "MR44V064BMAZAATL", "description": "F-RAM FeRAM/64Kbit 8Kb x 8 8pin SOP 3.4MHz", "category": "F-RAM", "price": 200.10 , "stock": 81, "reference": "755-MR44V064BMAZAATL", "image":"MR44V064BMAZAATL.webp" }' localhost:8080/api/product

