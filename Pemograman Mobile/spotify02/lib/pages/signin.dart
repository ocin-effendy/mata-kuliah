import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:spotify02/auth.dart';
import 'package:spotify02/navigations/tabbar.dart';

AuthenticationService service = AuthenticationService(FirebaseAuth.instance);

class SignIn extends StatefulWidget {
  const SignIn({Key? key, required this.check}) : super(key: key);
  final String check;
  @override
  State<SignIn> createState() => _SignInState();
}

class _SignInState extends State<SignIn> {
  final _formKey = GlobalKey<FormState>();
  final _username = TextEditingController();
  final _password = TextEditingController();
  String username = '';
  String password = '';

  

  @override
  Widget build(BuildContext context) {
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
                    onPressed: () {
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
                        Text(
                          widget.check,
                          style: const TextStyle(
                              color: Colors.white,
                              fontWeight: FontWeight.w800,
                              fontSize: 32),
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
                                    const Text(
                                      'Email atau nama pengguna',
                                      style: TextStyle(
                                          color: Colors.white,
                                          fontSize: 18,
                                          fontWeight: FontWeight.w600),
                                    ),
                                    TextFormField(
                                      controller: _username,
                                      style:
                                          const TextStyle(color: Colors.black),
                                      decoration: const InputDecoration(
                                          fillColor: Colors.white,
                                          filled: true),
                                    ),
                                  ],
                                ),
                                const SizedBox(
                                  height: 20,
                                ),
                                Column(
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                  children: [
                                    const Text(
                                      'Kata Sandi',
                                      style: TextStyle(
                                          color: Colors.white,
                                          fontSize: 18,
                                          fontWeight: FontWeight.w600),
                                    ),
                                    TextFormField(
                                      controller: _password,
                                      obscureText: true,
                                      style:
                                          const TextStyle(color: Colors.black),
                                      decoration: const InputDecoration(
                                          fillColor: Colors.white,
                                          filled: true),
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
                              onPressed: () async {
                                if (widget.check == 'MASUK') {
                                  if (await service.signIn(
                                      email: _username.text,
                                      password: _password.text)) {
                                    Navigator.of(context).pushAndRemoveUntil(
                                        MaterialPageRoute(
                                            builder: (BuildContext context) =>
                                                Tabbar(name: "niikooe")),
                                        (Route<dynamic> route) => false);
                                  }else{
																		print("Can't Sign In");
																	}
                                } else {
                                  if (await service.signUp(
                                      email: _username.text,
                                      password: _password.text)) {
                                    Navigator.of(context).pushAndRemoveUntil(
                                        MaterialPageRoute(
                                            builder: (BuildContext context) =>
                                                Tabbar(name: "niikooe")),
                                        (Route<dynamic> route) => false);
                                  }else{
																		print("Can't Sign Up");
																	}
                                }
                              },
                              style: ElevatedButton.styleFrom(
                                  primary: Colors.white,
                                  shape: const StadiumBorder()),
                              child: Text(
                                widget.check,
                                style: const TextStyle(
                                    color: Colors.black,
                                    fontWeight: FontWeight.w800,
                                    fontSize: 16),
                              )),
                        ),
                        SizedBox(
                          width: MediaQuery.of(context).size.width - 80,
                          child: const Text(
                            'Mengalami masalah saat masuk? Dapatkah bantuan di sini',
                            style: TextStyle(
                                color: Colors.white,
                                fontSize: 18,
                                fontWeight: FontWeight.w600),
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
    ));
  }
}
