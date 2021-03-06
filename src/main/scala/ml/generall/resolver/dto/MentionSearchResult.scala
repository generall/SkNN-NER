package ml.generall.resolver.dto

import ml.generall.resolver.tools.ProbTools

/**
  * Created by generall on 12.03.17.
  */
class MentionSearchResult(_vars: Iterable[ConceptVariant])(filterPredicate: (ConceptVariant => Boolean)) extends Serializable{
  val stats: Iterable[ConceptVariant] = {
    val avgs = _vars.map(_.avgScore)
    val avgsNorm = ProbTools.normalize(avgs)
    val avgsSotfMax = ProbTools.softMax(avgs)
    _vars.zip(avgsNorm.zip(avgsSotfMax)).map({ case (variant, (norm, softMax)) =>
      variant.avgSoftMax = softMax
      variant.avgNorm = norm
      variant
    }).filter(filterPredicate)
  }
}
