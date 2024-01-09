package kdu.backend;


public class SentimentAnalyzer {

    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length]; // output

        // Convert review to lowercase
        review = review.toLowerCase();

        // Iterate over each feature in the featureSet
        featureLoop:
        for (int i = 0; i < featureSet.length; i++) {
            String[] featureSynonyms = featureSet[i];

            // Iterate over each synonym for the feature
            for (String synonym : featureSynonyms) {
                // Check if the synonym exists in the review
                if (review.contains(synonym)) {
                    // Invoke getOpinionOnFeature and store the result
                    featureOpinions[i] = getOpinionOnFeature(review, synonym, posOpinionWords, negOpinionWords);
                    continue featureLoop;
                }
            }
        }

        return featureOpinions;
    }

    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
        if (opinion == 0) {
            opinion = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        }
        return opinion;
    }

    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";

        // Check for positive opinion
        for (String posOpinionWord : posOpinionWords) {
            if (review.contains(pattern + posOpinionWord)) {
                opinion = 1;
                break;
            }
        }

        // Check for negative opinion only if positive opinion is not found
        if (opinion == 0) {
            for (String negOpinionWord : negOpinionWords) {
                if (review.contains(pattern + negOpinionWord)) {
                    opinion = -1;
                    break;
                }
            }
        }

        return opinion;
    }

    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        // Extract sentences as the feature might appear multiple times
        String[] sentences = review.split("\\.");

        // Iterate over each sentence
        for (String sentence : sentences) {
            // Check for positive opinion
            for (String posOpinionWord : posOpinionWords) {
                if (sentence.contains(posOpinionWord + " " + feature)) {
                    opinion = 1;
                    return opinion; // No need to process subsequent sentences
                }
            }

            // Check for negative opinion only if positive opinion is not found
            if (opinion == 0) {
                for (String negOpinionWord : negOpinionWords) {
                    if (sentence.contains(negOpinionWord + " " + feature)) {
                        opinion = -1;
                        return opinion; // No need to process subsequent sentences
                    }
                }
            }
        }

        return opinion;
    }
}


