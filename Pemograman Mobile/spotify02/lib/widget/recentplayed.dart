import 'package:flutter/material.dart';
import 'package:spotify02/pages/album_page.dart';

class RecentPlayed extends StatelessWidget{
	final String name;
	final String linkImage;

  const RecentPlayed({Key? key, required this.name, required this.linkImage}) : super(key: key);


	@override
	Widget build(BuildContext context){
		return Container(
			margin: const EdgeInsets.only(right: 15),
			child: Column(
				children: [
					GestureDetector(
						onTap: () {
							Navigator.push(context,
								MaterialPageRoute(
									builder: (context) => Album(name: name, linkImage: linkImage)
								)
							);
						},
						child: ClipRRect(
							borderRadius: BorderRadius.circular(10),
							child: Image(
								image: AssetImage(linkImage),
								width: 130,
								height: 130,
								fit: BoxFit.cover,
							),
						),
					),
					const Padding(padding: EdgeInsets.only(top: 10)),
					SizedBox(
						width: 130,
						child: Center(
							child: Text(name,
								style: const TextStyle(
									color: Colors.white
								),
								softWrap: true,
							),
						),
					)

				],
			),
		);
	}
}
