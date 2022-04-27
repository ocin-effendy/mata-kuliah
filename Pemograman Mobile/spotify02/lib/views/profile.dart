import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:spotify02/pages/login_page.dart';

class ProfilePage extends StatefulWidget{
	
  @override
  State<ProfilePage> createState() => _ProfilePageState();
}

class _ProfilePageState extends State<ProfilePage> {
	void clearPreferences() async{
		final pref = await SharedPreferences.getInstance();
		pref.clear();
		Navigator.of(context).pushAndRemoveUntil( MaterialPageRoute(builder: (BuildContext context) => const Login()), (Route<dynamic> route) => false);
	}

	@override
	Widget build(BuildContext context){
		return Scaffold(
			body: Stack(
				children: [
					Container(
						width: MediaQuery.of(context).size.width,
						decoration: const BoxDecoration(
							color: Colors.teal
						),
					),
					Align(
						alignment: Alignment.center,
					  child: SizedBox(
					  	width: MediaQuery.of(context).size.width - 100,
							height: 50,
					  	child: ElevatedButton(
					  		onPressed: (){
									clearPreferences();
								}, 
					  		child: const Text('LogOut',
					  			style: TextStyle(
					  				color: Colors.white,
					  				fontSize: 24,
					  				fontWeight: FontWeight.w700
					  			),
					  		)
					  	)
					  ),
					)
				],
			),
		);
	}
}
