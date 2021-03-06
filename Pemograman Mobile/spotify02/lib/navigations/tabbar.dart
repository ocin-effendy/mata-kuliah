import 'package:flutter/material.dart';
import 'package:spotify02/mobx/passsong.dart';
import 'package:spotify02/mobx/passnameartist.dart';
import 'package:spotify02/mobx/passlinkimage.dart';
import 'package:spotify02/views/home.dart';
import 'package:spotify02/views/library.dart';
import 'package:spotify02/views/profile.dart';
import 'package:spotify02/views/search.dart';



class Tabbar extends StatefulWidget{
  final String name;
	const Tabbar({Key? key, required this.name}) : super(key: key);
  @override
  State<Tabbar> createState() => _TabbarState();
}

class _TabbarState extends State<Tabbar> {
	int _selectedTab = 0;

	@override
	Widget build(BuildContext context){
		return Scaffold(
			bottomNavigationBar: Container(
				decoration: const BoxDecoration(
					border: Border(top: BorderSide(color: Colors.grey, width: 0.5)),
				),
			  child: BottomNavigationBar(
			    currentIndex: _selectedTab,
			    onTap: (index) {
			  		setState(() {
			  			_selectedTab = index;
		  		});
		  	},

			    items: const  [
			  		BottomNavigationBarItem(
		  			icon: Icon(Icons.home),
		  			label: 'Home'
		  		),
			  		BottomNavigationBarItem(
			  			icon: Icon(Icons.search_outlined),
			  			label: 'Search'
			    	),
	  			BottomNavigationBarItem(
		  			icon: Icon(Icons.library_music),
			  			label: 'Library'
			    	),
		  		BottomNavigationBarItem(
			    		icon: Icon(Icons.person),
			    		label: 'Profile'
			    	),
			  	],
			   ),
			),
			body: Stack(
				children: [
					renderView(
						0, 
						HomePage(name: widget.name,),
					),
					renderView(
						1, 
						SearchPage()
					),
					renderView(
						2, 
						LibraryPage()
					),
					renderView(
						3, 
						ProfilePage()
					),
				],
			),
		);
	}

	Widget renderView(int tabIndex, Widget view){
		return IgnorePointer(
			ignoring: _selectedTab != tabIndex,
			child: Opacity(
				opacity: _selectedTab == tabIndex ? 1 : 0,
				child: view,
			),
		);
	}
}
