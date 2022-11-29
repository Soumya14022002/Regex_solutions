using System;
using System.Collections.Generic;
using System.IO;
using System.Text.RegularExpressions;

class Solution {
    static void Main(String[] args) {
        if (!int.TryParse(Console.ReadLine(), out var n)) throw new ArgumentException("Incorrect records count");

        var inputs = new List<string>();
        for (int i = 0; i < n; i++)
            inputs.Add(Console.ReadLine());

        var regex = new Regex("(\\d{1,3})[ ,-](\\d{1,3})[ ,-](\\d{4,10})");
        foreach (var record in inputs)
        {
            var match = regex.Match(record);
            var countryCode = match.Groups[1].Value.Trim();
            var localAreaCode = match.Groups[2].Value.Trim();
            var number = match.Groups[3].Value.Trim();
            Console.WriteLine($"CountryCode={countryCode},LocalAreaCode={localAreaCode},Number={number}");
        }
    }
}
