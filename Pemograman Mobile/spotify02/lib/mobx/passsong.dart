import 'package:mobx/mobx.dart';
part 'passsong.g.dart';

class PassSongMobx = _PassSongMobx with _$PassSongMobx;

abstract class _PassSongMobx with Store {
	@observable
	String value = '';

	@action
	void setSong(String nameSong){
		value = nameSong;
	}
}
