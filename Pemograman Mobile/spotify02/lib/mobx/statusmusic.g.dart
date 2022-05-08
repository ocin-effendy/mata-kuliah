// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'statusmusic.dart';

// **************************************************************************
// StoreGenerator
// **************************************************************************

// ignore_for_file: non_constant_identifier_names, unnecessary_brace_in_string_interps, unnecessary_lambdas, prefer_expression_function_bodies, lines_longer_than_80_chars, avoid_as, avoid_annotating_with_dynamic

mixin _$StatusMusicMobx on _StatusMusicMobx, Store {
  late final _$valueAtom =
      Atom(name: '_StatusMusicMobx.value', context: context);

  @override
  bool get value {
    _$valueAtom.reportRead();
    return super.value;
  }

  @override
  set value(bool value) {
    _$valueAtom.reportWrite(value, super.value, () {
      super.value = value;
    });
  }

  late final _$_StatusMusicMobxActionController =
      ActionController(name: '_StatusMusicMobx', context: context);

  @override
  void musicPlay() {
    final _$actionInfo = _$_StatusMusicMobxActionController.startAction(
        name: '_StatusMusicMobx.musicPlay');
    try {
      return super.musicPlay();
    } finally {
      _$_StatusMusicMobxActionController.endAction(_$actionInfo);
    }
  }

  @override
  void musicStop() {
    final _$actionInfo = _$_StatusMusicMobxActionController.startAction(
        name: '_StatusMusicMobx.musicStop');
    try {
      return super.musicStop();
    } finally {
      _$_StatusMusicMobxActionController.endAction(_$actionInfo);
    }
  }

  @override
  String toString() {
    return '''
value: ${value}
    ''';
  }
}
