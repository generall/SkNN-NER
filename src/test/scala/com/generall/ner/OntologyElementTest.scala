package com.generall.ner

import com.generall.ner.elements.OntologyElement
import org.scalatest.FunSuite

/**
  * Created by generall on 13.08.16.
  */
class OntologyElementTest extends FunSuite {

  test("testFeatures") {

    val elem = new OntologyElement("http://dbpedia.org/resource/James_Cameron")
    elem.features.foreach(println)
  }

}
