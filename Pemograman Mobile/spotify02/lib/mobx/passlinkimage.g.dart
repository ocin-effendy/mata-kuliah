// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'passlinkimage.dart';

// **************************************************************************
// StoreGenerator
// **************************************************************************

// ignore_for_file: non_constant_identifier_names, unnecessary_brace_in_string_interps, unnecessary_lambdas, prefer_expression_function_bodies, lines_longer_than_80_chars, avoid_as, avoid_annotating_with_dynamic

mixin _$PassLinkImageMobx on _PassLinkImageMobx, Store {
  late final _$valueAtom =
      Atom(name: '_PassLinkImageMobx.value', context: context);

  @override
  String get value {
    _$valueAtom.reportRead();
    return super.value;
  }

  @override
  set value(String value) {
    _$valueAtom.reportWrite(value, super.value, () {
      super.value = value;
    });
  }

  late final _$_PassLinkImageMobxActionController =
      ActionController(name: '_PassLinkImageMobx', context: context);

  @override
  void setLinkImage(String linkImage) {
    final _$actionInfo = _$_PassLinkImageMobxActionController.startAction(
        name: '_PassLinkImageMobx.setLinkImage');
    try {
      return super.setLinkImage(linkImage);
    } finally {
      _$_PassLinkImageMobxActionController.endAction(_$actionInfo);
    }
  }

  @override
  String toString() {
    return '''
value: ${value}
    ''';
  }
}
