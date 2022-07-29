import 'dart:convert';

class SongModel {
    SongModel({
        this.id = 1,
        required this.nameSong,
        required this.nameArtis,
        required this.linkImage,
        required this.categoriesId,
        this.createdAt = '',
        this.updatedAt = '',
    });

    int id;
    String nameSong;
    String nameArtis;
    String linkImage;
    int categoriesId;
    String createdAt;
    String updatedAt;

    factory SongModel.fromJson(Map<String, dynamic> data) => SongModel(
        id: data["id"],
        nameSong: data["nameSong"],
        nameArtis: data["nameArtis"],
        linkImage: data["linkImage"],
				categoriesId: data["Categories_id"],
        createdAt: data["created_at"],
        updatedAt: data["updated_at"],
    );

		Map<String, dynamic> toJson() => {
        "id": id,
        "nameSong": nameSong,
        "nameArtis": nameArtis,
        "linkImage": linkImage,
        "Categories_id": categoriesId,
        "created_at": createdAt,
        "updated_at": updatedAt,
    };
		
		@override
		String toString(){
		return 'SongModel{nameSong:$nameSong, nameArtis:$nameArtis, linkImage:$linkImage, categoriesId:$categoriesId}';
		}
}
List<SongModel> songModelFromJSON(List data){
		return List<SongModel>.from(data.map((item) => SongModel.fromJson(item)));
}

String songModelToJSON(SongModel data){
	return json.encode(data.toJson());
}
