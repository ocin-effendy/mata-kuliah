import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:spotify02/data/dummy_data.dart';
import 'package:spotify02/navigations/tabbar.dart';

class SignIn extends StatefulWidget{
  const SignIn({Key? key}) : super(key: key);

  @override
  State<SignIn> createState() => _SignInState();
}

class _SignInState extends State<SignIn> {
	final _formKey = GlobalKey<FormState>();
	final _username = TextEditingController();
	final _password = TextEditingController();
	String username = '';
	String password = '';
	List<Map<String, dynamic>> userCheck = DummyData.data;

	void setPreferences() async {
		final pref = await SharedPreferences.getInstance();
		for(int i = 0; i < userCheck.length; i++){
			if(userCheck[i]['username'] == _username.text && userCheck[i]['password'] == _password.text){
				pref.setString('name', userCheck[i]['nama'].toString());
				Navigator.of(context).pushAndRemoveUntil(MaterialPageRoute(builder: (BuildContext context) => Tabbar(name: userCheck[i]['nama'])), (Route<dynamic> route) => false);

			}
		}
	}


	@override
	Widget build(BuildContext context){
		return Scaffold(
			body: Stack(
				children: [
					Container(
						width: MediaQuery.of(context).size.width,
						height: MediaQuery.of(context).size.height,
						decoration: const BoxDecoration(
							color: Colors.blue,
						),
					),
					SingleChildScrollView(
					  child: SafeArea(
					    child: Container(
					  		padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 10),
					    	child: Column(
					  			crossAxisAlignment: CrossAxisAlignment.start,
					    		children: [
										IconButton(
											onPressed: (){
												Navigator.pop(context);
											}, 
											color: Colors.white,
											icon: const Icon(Icons.arrow_back_ios),
										),
					  				SizedBox(
					  					width: MediaQuery.of(context).size.width,
					  					height: MediaQuery.of(context).size.height - 100,
					  					child: Column(
					  						mainAxisAlignment: MainAxisAlignment.spaceAround,
					  						children: [
					  							const Text('Masuk',
					  								style: TextStyle(
					  									color: Colors.white,
					  									fontWeight: FontWeight.w800,
					  									fontSize: 32
					  								),
					  							),
					  							SizedBox(
					  								width: MediaQuery.of(context).size.width - 40,
					  							  child: Form(
					  							  	key: _formKey,
					  							    child: Column(
					  							      children: [
					  							        Column(
					  							  			  crossAxisAlignment: CrossAxisAlignment.start,
					  							          children: [
					  							  					const Text('Email atau nama pengguna',
					  							  						style: TextStyle(
					  							  							color: Colors.white,
					  															fontSize: 18,
					  															fontWeight: FontWeight.w600

					  							  						),
					  							  					),
					  							            TextFormField(
																				controller: _username,
																				style: const TextStyle(color: Colors.black),
					  							            	decoration: const InputDecoration(
					  							  							fillColor: Colors.white,
					  							  							filled: true
					  							            	),
					  							            ),
					  							          ],
					  							        ),
					  							  			const SizedBox(height: 20,),
					  							  			Column(
					  							  				crossAxisAlignment: CrossAxisAlignment.start,
					  							  		    children: [
					  							  					const Text('Kata Sandi',
					  							  						style: TextStyle(
					  							  							color: Colors.white,
					  															fontSize: 18,
					  															fontWeight: FontWeight.w600

					  							  						),
					  							  					),
					  							  		      TextFormField(
																				controller: _password,
																				obscureText: true,
																				style: const TextStyle(color: Colors.black),
					  							  						decoration: const InputDecoration(
																					fillColor: Colors.white,
																					filled: true
					  							  						),
					  							  					),
					  							  		    ],
					  							  		  ),
					  							      ],
					  							    ),
					  							  ),
					  							),
					  							SizedBox(
					  								width: MediaQuery.of(context).size.width - 230,
					  								height: 50,
					  								child: ElevatedButton(
					  									onPressed: (){setPreferences();},
					  									style: ElevatedButton.styleFrom(
					  										primary: Colors.white,
					  										shape: const StadiumBorder()
					  									),
					  									 child:const Text('MASUK',
					  										style: TextStyle(
					  											color: Colors.black,
					  											fontWeight: FontWeight.w800,
					  											fontSize: 16
					  										),
					  									)
					  								),
					  							),
					  							SizedBox(
					  								width: MediaQuery.of(context).size.width - 80,
					  							  child: const Text('Mengalami masalah saat masuk? Dapatkah bantuan di sini',
					  							  	style: TextStyle(
					  							  		color: Colors.white,
					  							  		fontSize: 18,
					  							  		fontWeight: FontWeight.w600
					  							  	),
					  									textAlign: TextAlign.center,
					  							  ),
					  							)
					  						],
					  					),
					  				)
					    		],
					    	),
					    ),
					  ),
					)
				],
			)
		);
	}
}
