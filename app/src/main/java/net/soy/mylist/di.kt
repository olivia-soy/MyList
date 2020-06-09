package net.soy.mylist

import net.soy.mylist.api.SearchServiceApi
import net.soy.mylist.model.NetworkRepositoryImpl
import net.soy.mylist.model.Repository
import net.soy.mylist.model.RetrofitFactory
import net.soy.mylist.ui.all.AllListViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

var viewModelPart = module {
    viewModel {
        AllListViewModel(get(), get())
    }
}


val retrofitPart = module {
    single<SearchServiceApi> {
        RetrofitFactory.build().create(SearchServiceApi::class.java)
    }
}
//
//var adapterPart = module {
//    factory {
//        MainSearchRecyclerViewAdapter()
//    }
//}

//factory{} -> DataModelImpl() 를 만들어줌
var modelPart = module {
    factory<Repository> {
        NetworkRepositoryImpl(get())
    }
}

var myDiModule = listOf(retrofitPart, modelPart, viewModelPart)
