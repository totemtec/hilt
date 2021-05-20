package com.demo.jiufengte.chapter05.a

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.databinding.Activity05Binding
import dagger.Component
import dagger.Module
import dagger.Provides

class Computer(private val name: String) {
    override fun toString(): String {
        return "Computer: $name"
    }
}

class Printer(private val name: String) {
    override fun toString(): String {
        return "Printer: $name"
    }
}

@Module
class ComputerModule {
    @Provides
    fun getComputer() = Computer("Dell")
}

@Module
class PrinterModule {
    @Provides
    fun getPrinter() = Printer("HP")
}

@Component(modules = [ComputerModule::class])
interface ComputerComponent {
    fun makeComputer(): Computer
}

@Component(modules = [PrinterModule::class])
interface PrinterComponent {
    fun makePrinter(): Printer
}


class Activity05a : AppCompatActivity() {

    private lateinit var binding: Activity05Binding

    lateinit var myComputer: Computer
    lateinit var myPrinter: Printer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity05Binding.inflate(layoutInflater)
        setContentView(binding.root)

        myComputer = DaggerComputerComponent.builder().build().makeComputer()
        myPrinter = DaggerPrinterComponent.create().makePrinter()

        binding.buttonComputer.setOnClickListener {
            binding.textView.text = myComputer.toString()
        }

        binding.buttonPrinter.setOnClickListener {
            binding.textView.text = myPrinter.toString()
        }
    }


}

