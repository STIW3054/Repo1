package testSuite;

import cloneRepo.CloneExecutorsTest;
import cloneRepo.JGitCloneWorkerTest;
import compileJava.CompileExecutorsTest;
import compileJava.CompileWorkerTest;
import determineFile.FileExecutorsTest;
import determineFile.FileWorkerTest;
import generateResults.GenerateErrorTest;
import generateResults.GenerateLogTest;
import generateResults.GenerateOutputTest;
import generateResults.GeneratePDFTest;
import generateResults.setupEnvironmentTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import retrieveRepo.GitRepoTest;
import runJava.RunExecutorsTest;
import runJava.RunWorkerTest;
import setupDirectory.MakeRepoDirTest;
import setupDirectory.MakeRootDirTest;
import setupDirectory.TargetRootTest;

//JUnit Suite Test
@RunWith(Suite.class)

@Suite.SuiteClasses({ 
   CloneExecutorsTest.class, JGitCloneWorkerTest.class, 
   CompileExecutorsTest.class, CompileWorkerTest.class,
   FileExecutorsTest.class, FileWorkerTest.class,
   
   GenerateErrorTest.class, GenerateLogTest.class, GenerateOutputTest.class, GeneratePDFTest.class, setupEnvironmentTest.class,
   GitRepoTest.class, 
   RunExecutorsTest.class, RunWorkerTest.class,
   MakeRepoDirTest.class, MakeRootDirTest.class, TargetRootTest.class
   
})

public class Project_TestSuite {
}