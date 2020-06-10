## **🗂MyList

##### 프로젝트 설명 

- 화면 구성 : 검색창과 그 결과를 보여주는 책 리스트 탭과 선호 책 리스트 탭으로 구성 

- 선호 책 리스트는 room을 사용하여 로컬 디비에 저장 (결과 리스트, 선호 리스트, 리스트 상세에서 선호 스위치 버튼을 통해 적용가능)

- 선호 리스트 정렬 가능 

- 책 리스트 아이템 선택시 상세화면으로 이동 

- 상세 화면에서 저자 선택시 저자 발간 책 리스트 보여줌 

- 카카오 책 검색 api를 이용하여 검색 결과에 맞는 책리스트 불러옴

- MVVM (Kotlin + datading + liveData)

  

##### 사용 라이브러리 

1. Android Architecture Components 

   1. Room
   2. paging
   3. lifecycle 
   4. viewModel
   5. LiveData
   6.  DataBinding 

2. Navigation Component

3. API 통신 

   1. Retrofit2 

4. 비동기 처리 

   1. RxJava2 - network
   2. Kotlin Coroutines - room 

5. Di

   1. Koin  

6. 이미지 처리 

   1. Glide

7. Ui

   1. RecyclerView
   2. Material Design (TabLayout) 

   