import 'dart:convert';
import 'dart:async';
import 'dart:io';
import 'package:http/http.dart' as http;
import 'package:spotify02/models/song_model.dart';

class ApiService {

  final $baseUrl = "http:localhost:8000";

  Future<List<SongModel>> getSongModel() async {
    final response = await http.get(
      Uri.parse('http://172.16.99.252:8000/api/v1/Songs'),
      headers: {
        HttpHeaders.authorizationHeader:
           'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwMDAvYXBpL3YxL2F1dGgvbG9naW4iLCJpYXQiOjE2NTcxMDM2ODgsImV4cCI6MTY1NzEwNzI4OCwibmJmIjoxNjU3MTAzNjg4LCJqdGkiOiJMdm51OVY5R2hFY3hDaW9HIiwic3ViIjoiMSIsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.YXa-6FgYX1otHQFTHMmeihVvQrBSpreGDhRztrxyd6I', 
        HttpHeaders.contentTypeHeader: 'application/json',
        HttpHeaders.acceptHeader: 'application/json',
      },
    );
    print(response.body);
    final responseJson = jsonDecode(response.body);
    print(responseJson);
		print('masuk sini');
    return songModelFromJSON(responseJson["data"]);
  }

  Future<bool> createSongModel(SongModel data) async {
    final response = await http.post(

      Uri.parse('http://172.16.99.252:8000/api/v1/Songs'),
      headers: {
        HttpHeaders.authorizationHeader:
           'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwMDAvYXBpL3YxL2F1dGgvbG9naW4iLCJpYXQiOjE2NTcxMDYyNjAsImV4cCI6MTY1NzEwOTg2MCwibmJmIjoxNjU3MTA2MjYwLCJqdGkiOiJyV3FiTGVWMkxTMzhJNUJKIiwic3ViIjoiMSIsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.0MYIcBVt67Z0UXTBq_-hrZz_1FHByB14ga8X1rv46OE', 
 
      HttpHeaders.contentTypeHeader: 'application/json; charset=utf-8',
        HttpHeaders.acceptHeader: 'application/json',
      },
      body: songModelToJSON(data),
    );

    print(response.statusCode);
    if (response.statusCode == 201) {
      return true;
    } else {
      return false;
    }
  }
}

Future<bool> updateSongModel(SongModel data) async {
  final response = await http.put(
			Uri.parse('http://127.0.0.1:8000/api/v1/Songs/${data.id}'),
    headers: {
HttpHeaders.authorizationHeader:
           'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwMDAvYXBpL3YxL2F1dGgvbG9naW4iLCJpYXQiOjE2NTcwOTIwNTAsImV4cCI6MTY1NzA5NTY1MCwibmJmIjoxNjU3MDkyMDUwLCJqdGkiOiJnelNDb1FOSUl6a2F5ZmIzIiwic3ViIjoiMSIsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.cMUTQ_oLpJQm1aN5x6Kpzap205swVDCCjqg0ZS4U5a4', 

      HttpHeaders.contentTypeHeader: 'application/json; charset=utf-8',
      HttpHeaders.acceptHeader: 'application/json',
    },
    body: songModelToJSON(data),
  );

  print(response.statusCode);
  if (response.statusCode == 200) {
    return true;
  } else {
    return false;
  }
}


Future<bool> deleteSongModel(int id) async{
  final response = await http.delete(
			Uri.parse('http://127.0.0.1:8000/api/v1/Songs/data.id'),
    headers: {
        HttpHeaders.authorizationHeader:
           'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwMDAvYXBpL3YxL2F1dGgvbG9naW4iLCJpYXQiOjE2NTcxMDM2ODgsImV4cCI6MTY1NzEwNzI4OCwibmJmIjoxNjU3MTAzNjg4LCJqdGkiOiJMdm51OVY5R2hFY3hDaW9HIiwic3ViIjoiMSIsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.YXa-6FgYX1otHQFTHMmeihVvQrBSpreGDhRztrxyd6I', 
    HttpHeaders.contentTypeHeader: 'application/json',
      HttpHeaders.acceptHeader: 'application/json',
    },
  );
	print(response.statusCode);
  if (response.statusCode == 200) {
    return true;
  } else {
    return false;
  }

}
