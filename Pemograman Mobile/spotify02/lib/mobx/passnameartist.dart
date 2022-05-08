import 'package:mobx/mobx.dart';
part 'passnameartist.g.dart';

class PassNameArtistMobx = _PassNameArtistMobx with _$PassNameArtistMobx;

abstract class _PassNameArtistMobx with Store {
	@observable
	String value = '';

	@action
	void setNameArtist(String nameArtist){
		value = nameArtist;
	}
}
