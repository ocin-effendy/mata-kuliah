import 'package:firebase_core/firebase_core.dart';
import 'package:firebase_messaging/firebase_messaging.dart';
import 'package:flutter/material.dart';
import 'package:spotify02/firebase_options.dart';
import 'package:spotify02/navigations/tabbar.dart';
import 'package:spotify02/notification_handler.dart';
import 'package:spotify02/pages/login_page.dart';
import 'package:spotify02/pages/signin.dart';

Future<void> main() async{
	WidgetsFlutterBinding.ensureInitialized();
	await Firebase.initializeApp(
			options: DefaultFirebaseOptions.currentPlatform
	);
	await initializeNotification();
	bool check = service.isUserLogged();
	
  runApp(
		MaterialApp(
			debugShowCheckedModeBanner: false,
			themeMode: ThemeMode.dark,
			darkTheme: ThemeData(
				scaffoldBackgroundColor: Colors.black,
				brightness: Brightness.dark,
				bottomNavigationBarTheme: const BottomNavigationBarThemeData(
					backgroundColor: Colors.black,
					type: BottomNavigationBarType.fixed,
					selectedLabelStyle: TextStyle( fontSize: 12),
					unselectedLabelStyle: TextStyle(fontSize: 12),
					selectedItemColor: Colors.teal,
					unselectedItemColor: Colors.white38
				)
			),
			home: check ? Tabbar(name: "niikooe") : const Login(),
		)
	);
}
