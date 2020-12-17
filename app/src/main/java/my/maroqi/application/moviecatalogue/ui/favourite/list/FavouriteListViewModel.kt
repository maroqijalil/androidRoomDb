package my.maroqi.application.moviecatalogue.ui.favourite.list

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import my.maroqi.application.moviecatalogue.data.FavouriteRepository
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.ui.main.list.CatalogueListViewModel
import my.maroqi.application.moviecatalogue.utility.ListItemType
import my.maroqi.application.moviecatalogue.utility.MovieResource
import my.maroqi.application.moviecatalogue.utility.TVResource
import my.maroqi.application.moviecatalogue.utility.launchIdling

class FavouriteListViewModel(svd: SavedStateHandle, ctx: Context) : ViewModel() {

    val savedState = svd
    private val context = ctx

//    private val dataList = MutableLiveData<ArrayList<*>>()
//    private var _dataList: ArrayList<*>? = null

//    private lateinit var type: ListItemType
//    private var vmCoroutineScope = CoroutineScope(Job() + Dispatchers.Default)

    private val dataRepository = FavouriteRepository(context)

    fun setType(type: ListItemType) {
//        this.type = type

//        if (this.type == ListItemType.MOVIE)
//            getMovieListData()
//        else if (this.type == ListItemType.TV_SHOW)
//            getTVListData()
//    }

//    fun getDataList(): LiveData<ArrayList<*>> {
//        return dataList
    }

    fun getAllMovie(): LiveData<PagedList<MovieItem>> =
        LivePagedListBuilder(dataRepository.getAllMoviePaged(), 5).build()

    fun getAllTV(): LiveData<PagedList<TVItem>> =
        LivePagedListBuilder(dataRepository.getAllTVPaged(), 5).build()

//    private fun getMovieListData() {
////        val movieList = dataRepository.getAllMovie()
//        vmCoroutineScope.launchIdling {
//            val resourceList = arrayListOf<MovieResource>()
//
//            dataRepository.getAllMovie().forEach { resourceList.add(MovieResource.getFavMovie(it)) }
//
//            dataList.postValue(resourceList)
//            _dataList = resourceList
//            saveDataList()
//        }
//    }
//
//    private fun getTVListData() {
//        vmCoroutineScope.launchIdling {
//            val resourceList = arrayListOf<TVResource>()
//
//            dataRepository.getAllTV()?.forEach { resourceList.add(TVResource.getFavTV(it)) }
//
//            dataList.postValue(resourceList)
//            _dataList = resourceList
//            saveDataList()
//        }
//    }
//
//    private fun saveDataList() {
//        if (type == ListItemType.MOVIE) {
//            if (savedState.contains(CatalogueListViewModel.MOVIE_SVD)) {
//                savedState.remove<ArrayList<*>>(CatalogueListViewModel.MOVIE_SVD)
//                savedState.set(CatalogueListViewModel.MOVIE_SVD, _dataList)
//            } else {
//                savedState.set(CatalogueListViewModel.MOVIE_SVD, _dataList)
//            }
//        } else if (type == ListItemType.TV_SHOW) {
//            if (savedState.contains(CatalogueListViewModel.TV_SVD)) {
//                savedState.remove<ArrayList<*>>(CatalogueListViewModel.TV_SVD)
//                savedState.set(CatalogueListViewModel.TV_SVD, _dataList)
//            } else {
//                savedState.set(CatalogueListViewModel.TV_SVD, _dataList)
//            }
//        }
//    }
//
//    fun loadDataList(): ArrayList<*>? {
//        return if (type == ListItemType.MOVIE) {
//            savedState.get<ArrayList<*>>(CatalogueListViewModel.MOVIE_SVD)
//        } else {
//            savedState.get<ArrayList<*>>(CatalogueListViewModel.TV_SVD)
//        }
//    }
}