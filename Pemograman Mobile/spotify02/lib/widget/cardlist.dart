import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class CardList extends StatelessWidget{
	final String title;

  const CardList({Key? key, required this.title}) : super(key: key);

	@override
	Widget build(BuildContext context){
		return SizedBox(
			width: double.infinity,
			child: Row(
				mainAxisAlignment: MainAxisAlignment.spaceBetween,
				children: [
					Text(title,
						style: GoogleFonts.poppins(
							color: Colors.white,
							fontWeight: FontWeight.w600,
							fontSize: 19
						),
					),
					const Icon(Icons.arrow_forward_ios,
						color: Colors.white,
						size: 15,
					)
				],
			),
		);
	}
}
