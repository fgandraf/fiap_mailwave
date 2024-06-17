package br.com.mailwave.repository

import br.com.mailwave.R
import br.com.mailwave.models.Email

class EmailRepository {

    companion object{
        fun getAllEmails(): List<Email>{

            return listOf(
                Email(R.drawable.profile_pic1, "Kristopher", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet consectetur adipiscing elit duis tristique.", false),
                Email(R.drawable.profile_pic2, "Elizabeth", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet consectetur adipiscing elit duis tristique.", false),
                Email(R.drawable.profile_pic3, "Joshua", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet consectetur adipiscing elit duis tristique.", false),
                Email(R.drawable.profile_pic3, "Joshua", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet consectetur adipiscing elit duis tristique.", true),
                Email(R.drawable.profile_pic1, "Kristopher", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet consectetur adipiscing elit duis tristique.", true),
                Email(R.drawable.profile_pic4, "Karen", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet consectetur adipiscing elit duis tristique.", false),
                Email(R.drawable.profile_pic2, "Elizabeth", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet consectetur adipiscing elit duis tristique.", true),
                Email(R.drawable.profile_pic3, "Joshua", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet consectetur adipiscing elit duis tristique.", true),
                Email(R.drawable.profile_pic4, "Karen", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet consectetur adipiscing elit duis tristique.", false),
                Email(R.drawable.profile_pic1, "Kristopher", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet consectetur adipiscing elit duis tristique.", true),
            )

        }
    }

}