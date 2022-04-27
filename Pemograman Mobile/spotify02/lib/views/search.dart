import 'package:flutter/material.dart';

class SearchPage extends StatelessWidget{
	
	@override
	Widget build(BuildContext context){
		return Scaffold(
			body: Stack(
				children: [
					Container(
						decoration: BoxDecoration(
							color: Colors.blue
						),
						child: Text('Search Page'),
					)
				],
			),
		);
	}
}
