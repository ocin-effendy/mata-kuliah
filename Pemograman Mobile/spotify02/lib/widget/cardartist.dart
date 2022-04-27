import 'package:flutter/material.dart';

class CardArtist extends StatelessWidget{

	final String name;
	final String linkImage;
  const CardArtist({Key? key, required this.name, required this.linkImage}) : super(key: key);


	@override
	Widget build(BuildContext context){
		return Container(
			margin: const EdgeInsets.only(right: 15),
			child: Column(
				children: [
					ClipRRect(
						borderRadius: BorderRadius.circular(50),
						child: Image(
							image: AssetImage(linkImage),
							width: 60,
							height: 60,
							fit: BoxFit.cover,
						),
					),
					const Padding(padding: EdgeInsets.only(top: 10)),
					SizedBox(
						width: 60,
						child: Center(
							child: Text(name,
								style: const TextStyle(
									color: Colors.white
								),
								overflow: TextOverflow.ellipsis,
							),
						),
					)
				],
			),
		);
	}
}
