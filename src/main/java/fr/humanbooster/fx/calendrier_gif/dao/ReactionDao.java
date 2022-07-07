package fr.humanbooster.fx.calendrier_gif.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.humanbooster.fx.calendrier_gif.business.Gif;
import fr.humanbooster.fx.calendrier_gif.business.Jour;
import fr.humanbooster.fx.calendrier_gif.business.Reaction;

public interface ReactionDao extends JpaRepository<Reaction, Long> {

	@Query("""
			SELECT r
			FROM Reaction r
			WHERE r.gif.jour.date >= :dateDebut and r.gif.jour.date < :dateFin
			""")
	List<Reaction> findAllReactionsByDayBetween(@Param("dateDebut") LocalDateTime dateDebut,
			@Param("dateFin") LocalDateTime dateFin);

	/**
	 * Done les 5 dernieres reactions pour un gif donné en parametre
	 * 
	 * @param gif
	 * @return
	 */
	List<Reaction> findLast5ByGif(Gif gif);

	/**
	 * Donne les 5 dernières réactions au gif du jour donné en paramètre
	 * 
	 * @param jour
	 * @return
	 */
	List<Reaction> findLast5ByGifJour(Jour jour);

	// dans ReactionDao déclarer une méthode qui donne les 5 dernières réactions au
	// gif du jour donné en paramètre
	List<Reaction> findLast5ByGifJourDateOrderByDateHeure(LocalDate localDate);

}
