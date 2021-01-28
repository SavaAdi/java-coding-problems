package com.adisava.searchproblems;

import java.util.ArrayList;
import java.util.Comparator;

public class Gene {

    private ArrayList<Codon> codons = new ArrayList<>();

    public Gene(String geneStr) {
        for (int i = 0; i < geneStr.length() - 3; i += 3) {
        // Take every 3 characters in the String and form a Codon
            codons.add(new Codon(geneStr.substring(i, i + 3)));
        }
    }

    public enum Nucleotide {
        A, C, G, T
    }

    public static class Codon implements Comparable<Codon> {

        public final Nucleotide first, second, third;

        private final Comparator<Codon> comparator =
                Comparator.comparing((Codon c) -> c.first)
                        .thenComparing((Codon c) -> c.second)
                        .thenComparing((Codon c) -> c.third);

        public Codon(String codonStr) {
            first = Nucleotide.valueOf(codonStr.substring(0, 1));
            second = Nucleotide.valueOf(codonStr.substring(1, 2));
            third = Nucleotide.valueOf(codonStr.substring(2, 3));
        }

        @Override
        public int compareTo(Codon other) {
            // first is compared first, then second, etc.
            // IOW first takes precedence over second
            // and second over third
            return comparator.compare(this, other);
        }
    }
}
