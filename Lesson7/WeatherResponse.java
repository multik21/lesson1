class Program
{
    private static HttpClient client = new HttpClient();

    static async Task Main(string[] args)
{
    try
    {
        WeatherResponse weatherResponse = await GetApiResponseAsync<WeatherResponse>("https://samples.openweathermap.org/data/2.5/find?q=London&units=metric&appid=439d4b804bc8187953eb36d2a8c26a02");

        foreach (WeatherData weatherData in weatherResponse.list)
        {
            Console.WriteLine(weatherData.name + ": " + weatherData.main.temp + " °C");
        }
    }
    catch (Exception ex)
    {
        Console.WriteLine(ex.Message);
    }
    Console.ReadKey();
}

    private static async Task<T> GetApiResponseAsync<T>(string url)
    {
        using (HttpResponseMessage response = await client.GetAsync(url, HttpCompletionOption.ResponseHeadersRead))
        {
            response.EnsureSuccessStatusCode();
            string json = await response.Content.ReadAsStringAsync();
            return JsonConvert.DeserializeObject<T>(json);
        }
    }
}