// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'passnameartist.dart';

// **************************************************************************
// StoreGenerator
// **************************************************************************

// ignore_for_file: non_constant_identifier_names, unnecessary_brace_in_string_interps, unnecessary_lambdas, prefer_expression_function_bodies, lines_longer_than_80_chars, avoid_as, avoid_annotating_with_dynamic

mixin _$PassNameArtistMobx on _PassNameArtistMobx, Store {
  late final _$valueAtom =
      Atom(name: '_PassNameArtistMobx.value', context: context);

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

  late final _$_PassNameArtistMobxActionController =
      ActionController(name: '_PassNameArtistMobx', context: context);

  @override
  void setNameArtist(String nameArtist) {
    final _$actionInfo = _$_PassNameArtistMobxActionController.startAction(
        name: '_PassNameArtistMobx.setNameArtist');
    try {
      return super.setNameArtist(nameArtist);
    } finally {
      _$_PassNameArtistMobxActionController.endAction(_$actionInfo);
    }
  }

  @override
  String toString() {
    return '''
value: ${value}
    ''';
  }
}
