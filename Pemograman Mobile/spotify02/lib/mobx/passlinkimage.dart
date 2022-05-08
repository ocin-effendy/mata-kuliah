import 'package:mobx/mobx.dart';
part 'passlinkimage.g.dart';

class PassLinkImageMobx = _PassLinkImageMobx with _$PassLinkImageMobx;

abstract class _PassLinkImageMobx with Store {
	@observable
	String value = '';

	@action
	void setLinkImage(String linkImage){
		value = linkImage;
	}
}
