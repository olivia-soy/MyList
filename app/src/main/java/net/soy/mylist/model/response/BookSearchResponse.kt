package net.soy.mylist.model.response

/**
 * Class: BookSearchResponse
 * Created by leesoyoung on 2020/06/04.
 *
 * Description: SearchService api Response 값
 */
data class BookSearchResponse(
    val documents: ArrayList<Document>,
    val meta :Meta
) {
    data class Document(
        val authors: ArrayList<String>, //도서 저자 리스트
        val contents: String,   //  도서 소개
        val datetime: String,   //  도서 출판 날짜
        val isbn: String,       //  국제 표준 도서 번호
        val price: Int,         //  도서 정가
        val publisher: String,  //  도서 출판사
        val sale_price: Int,    //  도서 판매가
        val status: String,     //  도서 판매 상태 정보 (정상, 품절, 절판 등)
        val thumbnail: String,  //  도서 표지 미리보기
        val title: String,      //  도서 제목
        val translators: ArrayList<String>, //  도서 번역자 리스트
        val url: String         //  도서 상세 url
    )
    data class Meta(
        val is_end: Boolean,
        val pageable_count: Int,
        val total_count: Int
    )
}