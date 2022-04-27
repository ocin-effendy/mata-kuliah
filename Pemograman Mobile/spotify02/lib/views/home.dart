import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:spotify02/widget/cardartist.dart';
import 'package:spotify02/widget/cardlist.dart';
import 'package:spotify02/widget/mfy.dart';
import 'package:spotify02/widget/recentplayed.dart';

class HomePage extends StatelessWidget{
  const HomePage({Key? key, required this.name}) : super(key: key);
	final String name;

	
	@override
	Widget build(BuildContext context){
		return Scaffold(
			body: Stack(
			alignment: Alignment.topLeft,
				children: [
					Container(
						width: MediaQuery.of(context).size.width,
						height: MediaQuery.of(context).size.height * .5,
						decoration: const BoxDecoration(
							color: Colors.teal
						),
					),
					SingleChildScrollView(
						child: Container(
							padding: const EdgeInsets.only(left: 15, right: 15),
							decoration: BoxDecoration(
								gradient: LinearGradient(
									begin: Alignment.topCenter,
									end: Alignment.bottomCenter,
									colors: [
										Colors.black.withOpacity(0),
										Colors.black.withOpacity(.9),
										Colors.black.withOpacity(1),
										Colors.black.withOpacity(1),
										Colors.black.withOpacity(1),
										Colors.black.withOpacity(1),
									]
								)
							),
							child: SafeArea(
								child: ListView(
									shrinkWrap: true,
									physics: const NeverScrollableScrollPhysics(),
									children: [
										SizedBox(
											width: double.infinity,
											child: Row(
												mainAxisAlignment: MainAxisAlignment.spaceBetween,
												children: [
													Column(
														crossAxisAlignment: CrossAxisAlignment.start,
														children: [
															const Padding(padding: EdgeInsets.only(bottom: 5)),
															SizedBox(
																width: MediaQuery.of(context).size.width - 60,
															  child: Text('Hello '+ name,
															  	style: GoogleFonts.poppins(
															  		fontWeight: FontWeight.w500,
															  		color: Colors.white,
															  		fontSize: 20
															  	),
															  	overflow: TextOverflow.ellipsis,
															  ),
															),
															Text("Let's listen to something cool today",
																style: GoogleFonts.poppins(
																	color: Colors.grey[200],
																	fontSize: 12
																),
															)
														],
													),
													Container(
														width: 30,
														height: 30,
														decoration: BoxDecoration(
															color: Colors.grey[700],
															borderRadius: const BorderRadius.all(Radius.circular(50))
														),
														child: const Icon(Icons.notifications_outlined, color: Colors.white,),
													)
												],
											),
										),

										Container(
											margin: const EdgeInsets.only(top: 20),
											child: Column(
												children: [
													const CardList(title: 'Your favorite artist'),
													const Padding(padding: EdgeInsets.only(top: 10)),
													SingleChildScrollView(
														scrollDirection: Axis.horizontal,
														physics: const BouncingScrollPhysics(),
														child: SizedBox(
															child: Row(
																mainAxisAlignment: MainAxisAlignment.start,
																children: const [
																	CardArtist(name: 'Olivia Rodrigo', linkImage: 'assets/Olivia.jpg'),
																	CardArtist(name: 'Billie Ellish', linkImage: 'assets/Billie.jpg'),
																	CardArtist(name: 'Xxxtantion', linkImage: 'assets/xxx.jpg'),
																	CardArtist(name: 'DuaLipa', linkImage: 'assets/Lipa.jpg'),
																	CardArtist(name: 'Post Malone', linkImage: 'assets/Malone.jpg'),
																	CardArtist(name: 'Zein Malik', linkImage: 'assets/Zein.jpg'),
																],
															),
														),
													)
												],
											),
										),

										Container(
											margin: const EdgeInsets.only(top: 20),
											child: Column(
												children: [
													const CardList(title: 'Recent played'),
													const Padding(padding: EdgeInsets.only(top: 10)),
													SingleChildScrollView(
														scrollDirection: Axis.horizontal,
														physics: const BouncingScrollPhysics(),
														child: SizedBox(
															child: Row(
																children: const [
																	RecentPlayed(name: 'Top Hip Hop 2022', linkImage: 'assets/recent2.jpeg'),
																	RecentPlayed(name: 'Top Rap 2022', linkImage: 'assets/recent3.jpeg'),
																	RecentPlayed(name: 'Top Hits 2021', linkImage: 'assets/recent1.jpeg'),
																	RecentPlayed(name: 'Top Indonesian', linkImage: 'assets/recent4.jpeg'),
																	
																],
															),
														),
													)
												],
											),
										),
										
										Container(
											margin: const EdgeInsets.only(top: 20),
											child: Column(
												children: [
													const CardList(title: 'Made for you'),
													const Padding(padding: EdgeInsets.only(top: 10)),
													SingleChildScrollView(
														scrollDirection: Axis.horizontal,
														physics: const BouncingScrollPhysics(),
														child: Row(
															children: const[
																MadeForYou(name: 'Daily Mix', linkImage: 'assets/mfy3.jpeg'),
																MadeForYou(name: 'Acoustic', linkImage: 'assets/mfy1.jpeg'),
																MadeForYou(name: 'Slowed', linkImage: 'assets/mfy2.jpeg'),
															],
														),
													)
												],
											),
										),
										Container(
											margin: const EdgeInsets.only(top: 20),
											child: Column(
												children: [
													const CardList(title: 'Recent played'),
													const Padding(padding: EdgeInsets.only(top: 10)),
													SingleChildScrollView(
														scrollDirection: Axis.horizontal,
														physics: const BouncingScrollPhysics(),
														child: SizedBox(
															child: Row(
																children: const [
																	RecentPlayed(name: 'Top Hip Hop 2022', linkImage: 'assets/recent2.jpeg'),
																	RecentPlayed(name: 'Top Rap 2022', linkImage: 'assets/recent3.jpeg'),
																	RecentPlayed(name: 'Top Hits 2021', linkImage: 'assets/recent1.jpeg'),
																	RecentPlayed(name: 'Top Indonesian 2022', linkImage: 'assets/recent4.jpeg'),
																	
																],
															),
														),
													)
												],
											),
										),
	
									],
								),
							),
						),
					)
				],
			),
		);
	}
}
