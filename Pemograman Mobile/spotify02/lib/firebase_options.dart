// File generated by FlutterFire CLI.
// ignore_for_file: lines_longer_than_80_chars, avoid_classes_with_only_static_members
import 'package:firebase_core/firebase_core.dart' show FirebaseOptions;
import 'package:flutter/foundation.dart'
    show defaultTargetPlatform, kIsWeb, TargetPlatform;

/// Default [FirebaseOptions] for use with your Firebase apps.
///
/// Example:
/// ```dart
/// import 'firebase_options.dart';
/// // ...
/// await Firebase.initializeApp(
///   options: DefaultFirebaseOptions.currentPlatform,
/// );
/// ```
class DefaultFirebaseOptions {
  static FirebaseOptions get currentPlatform {
    if (kIsWeb) {
      return web;
    }
    switch (defaultTargetPlatform) {
      case TargetPlatform.android:
        return android;
      case TargetPlatform.iOS:
        return ios;
      case TargetPlatform.macOS:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for macos - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      case TargetPlatform.windows:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for windows - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      case TargetPlatform.linux:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for linux - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      default:
        throw UnsupportedError(
          'DefaultFirebaseOptions are not supported for this platform.',
        );
    }
  }

  static const FirebaseOptions web = FirebaseOptions(
    apiKey: 'AIzaSyBWjhrEa5kSvik3XDpuJqDvG4FhzxSn_y0',
    appId: '1:91043379834:web:0a85a1edd59fb4f90d99c3',
    messagingSenderId: '91043379834',
    projectId: 'spotify-praktikum',
    authDomain: 'spotify-praktikum.firebaseapp.com',
    storageBucket: 'spotify-praktikum.appspot.com',
  );

  static const FirebaseOptions android = FirebaseOptions(
    apiKey: 'AIzaSyCd-7yZ62djwRvRBedOXkknuOkNXnUdPwI',
    appId: '1:91043379834:android:c5136d8887b836a20d99c3',
    messagingSenderId: '91043379834',
    projectId: 'spotify-praktikum',
    storageBucket: 'spotify-praktikum.appspot.com',
  );

  static const FirebaseOptions ios = FirebaseOptions(
    apiKey: 'AIzaSyA2ZkYNRZWREkCN3ecUm_V1RVxcyV6gW7E',
    appId: '1:91043379834:ios:2f98f99196cdf4840d99c3',
    messagingSenderId: '91043379834',
    projectId: 'spotify-praktikum',
    storageBucket: 'spotify-praktikum.appspot.com',
    iosClientId: '91043379834-rnul2c3s2nepeu5th4j5hh995uvnhkqh.apps.googleusercontent.com',
    iosBundleId: 'com.example.spotify02',
  );
}