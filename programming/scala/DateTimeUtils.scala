import java.time._                                   
import java.time.format._


object DateTimeUtils {

  def zones() : List[String] = {
    import scala.jdk.CollectionConverters._
    ZoneId.getAvailableZoneIds.iterator().asScala.toList
  }

  val kiev     : ZoneId = ZoneId.of("Europe/Kiev")
  val cet      : ZoneId = ZoneId.of("CET")
  val la       : ZoneId = ZoneId.of("America/Los_Angeles")

  val srilanka : ZoneId = ZoneId.of("Asia/Colombo")

  def fromLocalTimeToAnotherInDifferentZones(localIso: String, z1 : ZoneId, z2 : ZoneId) : String = {
    val ldt = LocalDateTime.parse(localIso, DateTimeFormatter.ISO_DATE_TIME)
    val zdt = ZonedDateTime.of(ldt, z1)
    val instant = zdt.toInstant
    val losAngelesZonedDateTime = ZonedDateTime.ofInstant(instant, z2)
    losAngelesZonedDateTime.toString
  }

  def fromLocalTimeToAnotherInDifferentZones(localIso: String, zoneIn: String, zoneOut: String) : String = {
    val ldt = LocalDateTime.parse(localIso, DateTimeFormatter.ISO_DATE_TIME)
    val zdt = ZonedDateTime.of(ldt, ZoneId.of(zoneIn))
    val instant = zdt.toInstant
    val losAngelesZonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of(zoneOut))
    losAngelesZonedDateTime.toString
  }

  def fromKievToZonedSriLanka(kievIso: String) : String = fromLocalTimeToAnotherInDifferentZones(kievIso, kiev, srilanka)

  def fromKievToZonedLosAngelos(kievIso: String) : String = fromLocalTimeToAnotherInDifferentZones(kievIso, "Europe/Kiev", "America/Los_Angeles")

  def fromLaToZonedKiev(laIso: String) : String = fromLocalTimeToAnotherInDifferentZones(laIso, "America/Los_Angeles", "Europe/Kiev")

  def fromCetToZonedKiev(cetIso: String) : String = fromLocalTimeToAnotherInDifferentZones(cetIso, "CET", "Europe/Kiev")


  //  2023 S****** Town Hall is going to take place on Apr 12, 5:00 PM - 6:00 PM (CEST) or 8:00 AM - 9:00 AM (PST)
  //DateTimeUtils.fromKievToZonedLosAngelos("2023-04-07T14:00:00")

}