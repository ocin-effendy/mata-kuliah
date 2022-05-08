import 'package:mobx/mobx.dart';
part 'statusmusic.g.dart';

class StatusMusicMobx = _StatusMusicMobx with _$StatusMusicMobx;

abstract class _StatusMusicMobx with Store {
	@observable
	bool value = false;

	@action
	void musicPlay(){
		value = true;
	}
	@action
	void musicStop(){
		value = false;
	}
}
