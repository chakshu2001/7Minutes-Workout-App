package com.example.android.a7minuteworkout

class Constants {
    companion object{
        fun defaultExerciseList():ArrayList<ExerciseModel>{


            var exerciseList=ArrayList<ExerciseModel>()
            var jumpingJacks=ExerciseModel(1,
                "JumpingJacks",
                R.drawable.ic_jumping_jacks,
                false,
                false)
            exerciseList.add(jumpingJacks)
            var wallSit=ExerciseModel(2,
                "Wall Sit",
                R.drawable.ic_wall_sit,
                false,
                false)
            exerciseList.add(wallSit)
            var pushUp=ExerciseModel(3,
                "Push Up",
                R.drawable.ic_push_up,
                false,
                false)
            exerciseList.add(pushUp)
            var abdominalCrunch=ExerciseModel(4,
                "Abdominal Crunch",
                R.drawable.ic_abdominal_crunch,
                false,
                false)
            exerciseList.add(abdominalCrunch)
            var stepOnChair=ExerciseModel(5,
                "Step On Chair",
                R.drawable.ic_step_up_onto_chair,
                false,
                false)
            exerciseList.add(stepOnChair)
            var squat=ExerciseModel(6,
            "Squat",
            R.drawable.ic_squat,
            false,false)
            exerciseList.add(squat)
            var tricepDipOnChair=ExerciseModel(7,
                "Tricep Dip On Chair",
                R.drawable.ic_triceps_dip_on_chair,
                false,
                false)
            exerciseList.add(tricepDipOnChair)
            var plank=ExerciseModel(8,
                "Plank",
                R.drawable.ic_plank,
                false,
                false)
            exerciseList.add(plank)
            var highKneesRunningShoes=ExerciseModel(9,
                "High Knees Running In Place",
            R.drawable.ic_high_knees_running_in_place,
            false,
            false)
            exerciseList.add(highKneesRunningShoes)
            var lunges=ExerciseModel(10,
                "Lunges",
                R.drawable.ic_lunge,
                false,
                false)
            exerciseList.add(lunges)
            var pushupAndRotation=ExerciseModel(11,
            "Push up and rotation",
            R.drawable.ic_push_up_and_rotation,false,false)
            exerciseList.add(pushupAndRotation)
            var sidePlank=ExerciseModel(12,"Side Plank", R.drawable.ic_side_plank,
            false,false)
            exerciseList.add(sidePlank)

            return exerciseList
        }
    }
}