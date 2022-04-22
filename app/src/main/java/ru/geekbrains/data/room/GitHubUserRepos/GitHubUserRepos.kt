package ru.geekbrains.data.room.GitHubUserRepos

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "GithubUserReposTable")
data class GitHubUserRepos(
    @PrimaryKey
    @ColumnInfo
    @SerializedName("id")
    val id: String,

    @ColumnInfo
    @SerializedName("name")
    val name: String? = null,

    @ColumnInfo
    @SerializedName("login")
    val login: String? = null,

    @ColumnInfo
    @SerializedName("full_name")
    val full_name: String? = null,

    @ColumnInfo
    @SerializedName("node_id")
    val node_id: String = "",

    @ColumnInfo
    @SerializedName("html_url")
    val html_url: String = ""
    ): Parcelable
