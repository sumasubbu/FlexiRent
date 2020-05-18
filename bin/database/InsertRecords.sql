INSERT INTO PROPERTY_TYPE (TYPE_NAME) VALUES ('APARTMENT');
INSERT INTO PROPERTY_TYPE (TYPE_NAME) VALUES ('PRIME SUITE');

INSERT INTO PROPERTY_STATUS (STATUS_NAME) VALUES ('AVAILABLE');
INSERT INTO PROPERTY_STATUS (STATUS_NAME) VALUES ('RENTED');
INSERT INTO PROPERTY_STATUS (STATUS_NAME) VALUES ('UNDER MAINTENANCE');

INSERT INTO RENTAL_PROPERTY (LONG_DESCRIPTION, 
							 SHORT_DESCRIPTION, 
							 STATUS_ID, 
							 TYPE_ID, 
							 NUM_BEDROOMS, 
							 TITLE, 
							 PROPERTY_ID,
							 STREET_NUM,
							 STREET_NAME,
							 SUBURB)
			VALUES (
				'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus ullamcorper eleifend ex vitae blandit. Donec eu neque dapibus nulla posuere rutrum at quis eros. Integer convallis orci eget tortor eleifend elementum. Mauris massa turpis, consectetur non ipsum et, malesuada faucibus tellus. Proin viverra magna ut odio rutrum, et lacinia massa malesuada. Nulla lacinia orci magna, eu eleifend nulla tincidunt eget. Mauris feugiat mattis dolor, nec sodales dui placerat non. Sed ac mattis magna. Donec eleifend urna et justo accumsan, viverra finibus nisi tempor. Morbi id interdum tellus.Nullam porta ipsum non libero accumsan, nec commodo lectus porttitor. Fusce tincidunt magna ac dui mattis laoreet eget eu quam. Praesent ullamcorper lacus id mauris lacinia commodo. Fusce magna eros, vestibulum sed aliquet eget, maximus ut nunc. Nam porttitor quam a felis fermentum, quis tempus purus tempus. Mauris et vehicula mi, vitae viverra risus. Nunc ipsum leo, convallis a libero aliquet, porta ornare nisi. In commodo et sem eget rhoncus. Nulla vitae placerat sapien, et porttitor diam. Aenean lacinia dictum magna, at vulputate leo ultricies eu. Integer placerat dolor enim. Etiam neque nunc, euismod ac ligula et, sagittis congue nibh. Nam eleifend mattis metus elementum fringilla. Duis viverra nisi suscipit massa feugiat placerat.',
				'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus ullamcorper eleifend ex vitae blandit.',
				100,
				100,
				2,
				'TWO BEDROOM APT IN CHENNAI',
				'A_2_CHENNAI_100',
				1212,
				'MAIN STREET',
				'CHENNAI'
				);

INSERT INTO RENTAL_PROPERTY (LONG_DESCRIPTION, 
							 SHORT_DESCRIPTION, 
							 STATUS_ID, 
							 TYPE_ID, 
							 NUM_BEDROOMS, 
							 TITLE, 
							 PROPERTY_ID,
							 STREET_NUM,
							 STREET_NAME,
							 SUBURB)
			VALUES (
				'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus ullamcorper eleifend ex vitae blandit. Donec eu neque dapibus nulla posuere rutrum at quis eros. Integer convallis orci eget tortor eleifend elementum. Mauris massa turpis, consectetur non ipsum et, malesuada faucibus tellus. Proin viverra magna ut odio rutrum, et lacinia massa malesuada. Nulla lacinia orci magna, eu eleifend nulla tincidunt eget. Mauris feugiat mattis dolor, nec sodales dui placerat non. Sed ac mattis magna. Donec eleifend urna et justo accumsan, viverra finibus nisi tempor. Morbi id interdum tellus.Nullam porta ipsum non libero accumsan, nec commodo lectus porttitor. Fusce tincidunt magna ac dui mattis laoreet eget eu quam. Praesent ullamcorper lacus id mauris lacinia commodo. Fusce magna eros, vestibulum sed aliquet eget, maximus ut nunc. Nam porttitor quam a felis fermentum, quis tempus purus tempus. Mauris et vehicula mi, vitae viverra risus. Nunc ipsum leo, convallis a libero aliquet, porta ornare nisi. In commodo et sem eget rhoncus. Nulla vitae placerat sapien, et porttitor diam. Aenean lacinia dictum magna, at vulputate leo ultricies eu. Integer placerat dolor enim. Etiam neque nunc, euismod ac ligula et, sagittis congue nibh. Nam eleifend mattis metus elementum fringilla. Duis viverra nisi suscipit massa feugiat placerat.',
				'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus ullamcorper eleifend ex vitae blandit.',
				100,
				101,
				3,
				'THREE BEDROOM SUIT',
				'S_3_COIMBATORE_101',
				201, 
				'HOLA STREET', 
				'COIMBATORE'
				);
INSERT INTO RENTAL_PROPERTY (LONG_DESCRIPTION, 
							 SHORT_DESCRIPTION, 
							 STATUS_ID, 
							 TYPE_ID, 
							 NUM_BEDROOMS, 
							 TITLE, 
							 PROPERTY_ID,
							 STREET_NUM,
							 STREET_NAME,
							 SUBURB)
			VALUES (
				'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus ullamcorper eleifend ex vitae blandit. Donec eu neque dapibus nulla posuere rutrum at quis eros. Integer convallis orci eget tortor eleifend elementum. Mauris massa turpis, consectetur non ipsum et, malesuada faucibus tellus. Proin viverra magna ut odio rutrum, et lacinia massa malesuada. Nulla lacinia orci magna, eu eleifend nulla tincidunt eget. Mauris feugiat mattis dolor, nec sodales dui placerat non. Sed ac mattis magna. Donec eleifend urna et justo accumsan, viverra finibus nisi tempor. Morbi id interdum tellus.Nullam porta ipsum non libero accumsan, nec commodo lectus porttitor. Fusce tincidunt magna ac dui mattis laoreet eget eu quam. Praesent ullamcorper lacus id mauris lacinia commodo. Fusce magna eros, vestibulum sed aliquet eget, maximus ut nunc. Nam porttitor quam a felis fermentum, quis tempus purus tempus. Mauris et vehicula mi, vitae viverra risus. Nunc ipsum leo, convallis a libero aliquet, porta ornare nisi. In commodo et sem eget rhoncus. Nulla vitae placerat sapien, et porttitor diam. Aenean lacinia dictum magna, at vulputate leo ultricies eu. Integer placerat dolor enim. Etiam neque nunc, euismod ac ligula et, sagittis congue nibh. Nam eleifend mattis metus elementum fringilla. Duis viverra nisi suscipit massa feugiat placerat.',
				'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus ullamcorper eleifend ex vitae blandit.',
				100,
				101,
				7,
				'PREMIUM BEDROOM SUIT',
				'S_7_CHENNAI_102',
				501, 
				'QUEEN STREET',
				'CHENNAI'
				);

				COMMIT;
				
				SHUTDOWN