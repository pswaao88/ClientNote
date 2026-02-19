package com.clientnote.data

data class CustomerUi(
    val id: Long,
    val name: String,
    val phone: String,
    val address: String,
    val copierCount: Int
)

data class CopierUi(
    val id: Long,
    val customerId: Long,
    val brand: String,
    val model: String,
    val serial: String
)

data class LogUi(
    val id: Long,
    val title: String,
    val detail: String,
    val dateLabel: String
)

object MockData {
    val customers = listOf(
        CustomerUi(1, "에이스 프린팅", "010-1111-2222", "서울 강서구", 2),
        CustomerUi(2, "한빛 사무기", "010-3333-4444", "서울 양천구", 1),
        CustomerUi(3, "동네 교회", "010-5555-6666", "경기 부천시", 1)
    )

    val copiers = listOf(
        CopierUi(1, 1, "Canon", "IR-ADV C5535", "SN-AX1902"),
        CopierUi(2, 1, "HP", "LaserJet M725", "SN-HP4848"),
        CopierUi(3, 2, "Samsung", "SL-X4300", "SN-SM1291"),
        CopierUi(4, 3, "Ricoh", "MP C3504", "SN-RC5501")
    )

    val repairs = listOf(
        LogUi(1, "용지 걸림", "급지 롤러 교체 및 테스트", "2026-02-17"),
        LogUi(2, "출력 흐림", "토너 재장착 후 보정", "2026-02-12")
    )

    val consumables = listOf(
        LogUi(1, "드럼 교체", "Black Drum 1EA", "2026-02-10"),
        LogUi(2, "토너 교체", "Cyan Toner 1EA", "2026-02-05")
    )
}
