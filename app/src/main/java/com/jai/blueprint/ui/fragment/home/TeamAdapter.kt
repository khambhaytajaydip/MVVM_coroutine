package com.jai.blueprint.ui.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jai.blueprint.data.model.Team
import com.jai.blueprint.databinding.ItemTeamViewBinding
import com.jai.blueprint.ui.base.BaseViewHolder

/**
 * Created by JAI on 15,November,2019
 * JAI KHAMBHAYTA
 */
class TeamAdapter(var teamList: List<Team>) : RecyclerView.Adapter<BaseViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val mMovieViewBinding = ItemTeamViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return TeamViewHolder(mMovieViewBinding)

    }

    override fun getItemCount(): Int = teamList.size


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }


    inner class TeamViewHolder(val mMovieViewBinding: ItemTeamViewBinding?) :
        BaseViewHolder(mMovieViewBinding!!.root), TeamItemViewModel.MovieItemViewModelListener {
        override fun onItemClick(team: Team) {

        }

        private lateinit var teamItemViewModel: TeamItemViewModel
        override fun onBind(position: Int) {
            val movie = teamList[position]
            teamItemViewModel = TeamItemViewModel(movie, this)
            mMovieViewBinding!!.viewModel = teamItemViewModel
            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mMovieViewBinding!!.executePendingBindings()
        }
    }
}


