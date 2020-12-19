package johan.kovalsikoski.parperfeito.ui.feature.announcement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import johan.kovalsikoski.parperfeito.R
import johan.kovalsikoski.parperfeito.databinding.FragmentAnnouncementBinding


class AnnouncementFragment : Fragment(R.layout.fragment_announcement) {

    private lateinit var binding: FragmentAnnouncementBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnnouncementBinding.inflate(inflater, container, false)
        return binding.root
    }
}
