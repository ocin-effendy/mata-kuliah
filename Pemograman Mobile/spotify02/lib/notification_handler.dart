import 'package:firebase_messaging/firebase_messaging.dart';
import 'package:flutter/material.dart';
import 'package:flutter_local_notifications/flutter_local_notifications.dart';

final FlutterLocalNotificationsPlugin flutterLocalNotificationsPlugin =
    FlutterLocalNotificationsPlugin();

initializeNotification() async {
  final fcm = FirebaseMessaging.instance;
  debugPrint(
      "Token: ${(await FirebaseMessaging.instance.getToken()).toString()}");

  try {
    await fcm.requestPermission(alert: true, badge: true, sound: true);
    await fcm.setForegroundNotificationPresentationOptions(
        alert: true, badge: true, sound: true);
    FirebaseMessaging.onMessage.listen(_onMessage);
    FirebaseMessaging.onBackgroundMessage(_onBackgroundMessage);
    FirebaseMessaging.onMessageOpenedApp.listen(_onOpened);
		

  } catch (e) {
    debugPrint(e.toString());
  }
}

void _onMessage(RemoteMessage message) {
  debugPrint("Kamu menerima pesan! ${message.notification?.title}");
  debugPrint("${message.notification?.body}");

  RemoteNotification? notification = message.notification;
  AndroidNotification? android = message.notification?.android;

  if (notification != null && android != null) {
    flutterLocalNotificationsPlugin.show(
        notification.hashCode,
        notification.title,
        notification.body,
        NotificationDetails(
            android: AndroidNotificationDetails(
          channel.id,
          channel.name,
          color: Colors.blue,
          icon: '@mipmap/ic_launcher',
        )));
  }
}

Future<void> _onBackgroundMessage(RemoteMessage message) async {
  debugPrint("Kamu menerima pesan! ${message.notification?.title}");
  debugPrint("${message.notification?.body}");
	
}

void _onOpened(RemoteMessage message) async {
  final data = message.data;
  debugPrint("Kamu bisa melakukan apapun pada data! $data");
}

const AndroidNotificationChannel channel = AndroidNotificationChannel(
  'channel', // id
  'channel', // title
  importance: Importance.high,
  playSound: true,
);
