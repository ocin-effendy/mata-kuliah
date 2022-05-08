// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'passsong.dart';

// **************************************************************************
// StoreGenerator
// **************************************************************************

// ignore_for_file: non_constant_identifier_names, unnecessary_brace_in_string_interps, unnecessary_lambdas, prefer_expression_function_bodies, lines_longer_than_80_chars, avoid_as, avoid_annotating_with_dynamic

mixin _$PassSongMobx on _PassSongMobx, Store {
  late final _$valueAtom = Atom(name: '_PassSongMobx.value', context: context);

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

  late final _$_PassSongMobxActionController =
      ActionController(name: '_PassSongMobx', context: context);

  @override
  void setSong(String nameSong) {
    final _$actionInfo = _$_PassSongMobxActionController.startAction(
        name: '_PassSongMobx.setSong');
    try {
      return super.setSong(nameSong);
    } finally {
      _$_PassSongMobxActionController.endAction(_$actionInfo);
    }
  }

  @override
  String toString() {
    return '''
value: ${value}
    ''';
  }
}
