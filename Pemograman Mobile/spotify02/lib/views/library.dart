import 'package:flutter/material.dart';
import 'package:spotify02/widget/musicplay.dart';

class LibraryPage extends StatelessWidget{
	
	@override
	Widget build(BuildContext context){
		return Scaffold(
			body: Stack(
				children: [
					Container(
						decoration: BoxDecoration(
							color: Colors.orange
						),
						child: Text('Library Page'),
					),
					MusicPlay(),
				],
			),
		);
	}
}
