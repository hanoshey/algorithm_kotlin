private data class Delivery(
    val address: String,
    val time: String,
    val items: List<String>
)
private val sampleDeliveryList = listOf(
    Delivery(
        address = "서울시 강남구 역삼동 111-333",
        time = "2021-01-01 13:00:00",
        items = listOf("콩나물밥", "불고기비빔밥", "냉모밀")
    ),
    Delivery(
        address = "서울시 강남구 역삼동 222-333",
        time = "2021-01-01 13:00:00",
        items = listOf("콩나물밥", "불고기비빔밥", "냉모밀")
    ),
)