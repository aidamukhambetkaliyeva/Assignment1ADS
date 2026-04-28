public class Experiment {

        private Sorter sorter = new Sorter();
        private Searcher searcher = new Searcher();

        public long measureSortTime(int[] arr, String type) {
            int[] copy = arr.clone();

            long start = System.nanoTime();

            if (type.equals("basic")) {
                sorter.basicSort(copy);
            } else if (type.equals("advanced")) {
                sorter.advancedSort(copy);
            }

            long end = System.nanoTime();
            return end - start;
        }

        public long measureSearchTime(int[] arr, int target) {
            long start = System.nanoTime();

            searcher.search(arr, target);

            long end = System.nanoTime();
            return end - start;
        }

        public void runAllExperiments() {

            int[] sizes = {10, 100, 1000};

            for (int size : sizes) {

                System.out.println("Array size: " + size);

                int[] randomArr = sorter.generateRandomArray(size);
                int[] sortedArr = randomArr.clone();
                sorter.basicSort(sortedArr);

                long basicTimeRandom = measureSortTime(randomArr, "basic");
                long advancedTimeRandom = measureSortTime(randomArr, "advanced");

                long basicTimeSorted = measureSortTime(sortedArr, "basic");
                long advancedTimeSorted = measureSortTime(sortedArr, "advanced");

                int target = randomArr[size / 2];

                long searchTimeRandom = measureSearchTime(randomArr, target);
                long searchTimeSorted = measureSearchTime(sortedArr, target);

                System.out.println("Random array:");
                System.out.println("Basic sort: " + basicTimeRandom);
                System.out.println("Advanced sort: " + advancedTimeRandom);
                System.out.println("Search: " + searchTimeRandom);

                System.out.println("Sorted array:");
                System.out.println("Basic sort: " + basicTimeSorted);
                System.out.println("Advanced sort: " + advancedTimeSorted);
                System.out.println("Search: " + searchTimeSorted);

                System.out.println("----------------------------");
            }
        }
    }


