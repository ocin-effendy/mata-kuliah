import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class MadeForYou extends StatelessWidget{
	final String name;
	final String linkImage;
  const MadeForYou({Key? key, required this.name, required this.linkImage}) : super(key: key);

	@override
	Widget build(BuildContext context){
		return Container(
			margin: const EdgeInsets.only(right: 15),
			child: Container(
				decoration: BoxDecoration(
					image: DecorationImage(
						image: AssetImage(linkImage),
						fit: BoxFit.fitHeight
					),
					borderRadius: BorderRadius.circular(10)
				),
				width: 130,
				height: 155,
				child: Align(
					alignment: Alignment.bottomCenter,
					child: Text(name,
						style: GoogleFonts.poppins(
							color: Colors.white,
							fontSize: 20,
							fontWeight: FontWeight.w900
						),
					),
				),
			),
		);
	}
}
