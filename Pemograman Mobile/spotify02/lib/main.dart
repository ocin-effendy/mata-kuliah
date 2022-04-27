import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:spotify02/navigations/tabbar.dart';
import 'package:spotify02/pages/login_page.dart';

Future<void> main() async{
	WidgetsFlutterBinding.ensureInitialized();
	final pref = await SharedPreferences.getInstance();
	String name = pref.getString('name').toString();
	bool check = pref.getString('name') != null;
  runApp(
		MaterialApp(
			debugShowCheckedModeBanner: false,
			themeMode: ThemeMode.dark,
			darkTheme: ThemeData(
				scaffoldBackgroundColor: Colors.black,
				brightness: Brightness.dark,
				bottomNavigationBarTheme: const BottomNavigationBarThemeData(
					backgroundColor: Colors.white10,
					type: BottomNavigationBarType.fixed,
					selectedLabelStyle: TextStyle( fontSize: 12),
					unselectedLabelStyle: TextStyle(fontSize: 12),
					selectedItemColor: Colors.teal,
					unselectedItemColor: Colors.white38
				)
			),
			home: check ? Tabbar(name: name) : const Login(),
		)
	);
}

class MyApp extends StatefulWidget{
  const MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
	String name = '';
	bool check = false;
	void getPreferences() async{
	final pref = await SharedPreferences.getInstance();
		
		name = pref.getString('name').toString();
		if(pref.getString('name') != null){
			setState(() {
				check = true;
			});
		}
	}

	@override
	  void initState() {
			getPreferences();
	    super.initState();
	  }
	@override
	Widget build(BuildContext context){
		return MaterialApp(
			debugShowCheckedModeBanner: false,
			themeMode: ThemeMode.dark,
			darkTheme: ThemeData(
				scaffoldBackgroundColor: Colors.black,
				brightness: Brightness.dark,
				bottomNavigationBarTheme: const BottomNavigationBarThemeData(
					backgroundColor: Colors.white10,
					type: BottomNavigationBarType.fixed,
					selectedLabelStyle: TextStyle( fontSize: 12),
					unselectedLabelStyle: TextStyle(fontSize: 12),
					selectedItemColor: Colors.teal,
					unselectedItemColor: Colors.white38
				)
			),
			home: check ? Tabbar(name: name) : const Login(),
		);
	}
}
