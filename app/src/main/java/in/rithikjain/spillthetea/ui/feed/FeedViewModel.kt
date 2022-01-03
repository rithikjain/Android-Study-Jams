package `in`.rithikjain.spillthetea.ui.feed

import `in`.rithikjain.spillthetea.data.local.entity.Post
import `in`.rithikjain.spillthetea.data.repository.PostRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    val posts = repository.getPosts()

    fun deletePost(post: Post) {
        viewModelScope.launch {
            repository.deletePost(post)
        }
    }

}